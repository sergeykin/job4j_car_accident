package ru.job4j.job4j_car_accident.repository;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.job4j.job4j_car_accident.model.Accident;
import ru.job4j.job4j_car_accident.model.AccidentType;
import ru.job4j.job4j_car_accident.model.Rule;


import java.sql.PreparedStatement;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@Repository
public class AccidentJdbcTemplate {
    private final JdbcTemplate jdbc;

    public AccidentJdbcTemplate(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public Accident save(Accident accident) {
        jdbc.update("insert into accident (name,text,address) values (?,?,?)",
                accident.getName()
        ,accident.getText()
        ,accident.getAddress());
        return accident;
    }

    public List<Accident> getAll() {
        return jdbc.query("select id, name, text, address from accident",
                (rs, row) -> {
                    Accident accident = new Accident();
                    accident.setId(rs.getInt("id"));
                    accident.setName(rs.getString("name"));
                    return accident;
                });
    }

    public Accident add(Accident accident) {

        if (accident == null) {
            return null;
        }
        if (accident.getId() == 0) {

            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbc.update(connection -> {
                PreparedStatement ps = connection.prepareStatement("insert into accident (name,text,address, type_id) values (?,?,?,?)", new String[] { "id" });
                ps.setString(1, accident.getName());
                ps.setString(2, accident.getText());
                ps.setString(3, accident.getAddress());
                ps.setInt(4, accident.getType().getId());
                return ps;
            }, keyHolder);
            accident.setType(this.getTypeID(accident.getType().getId()));
            accident.setId((Integer) keyHolder.getKey());
        } else {
            jdbc.update("update accident " +
                            "set name = ?" +
                            ",text = ?" +
                            ",address =?" +
                            ", type_id = ?" +
                            "where id = ?",
                    accident.getName()
                    , accident.getText()
                    , accident.getAddress()
                    , accident.getType().getId()
                    , accident.getId());
        }
        jdbc.update("delete from rule_accident " +
                        "where accident_id = ?"
                , accident.getId());

        for (Rule rule : accident.getRules()) {
            jdbc.update("insert into rule_accident (accident_id, rule_id) values (?,?)",
                    accident.getId()
                    ,rule.getId()                    );
        }
        return accident;
    }

    public AccidentType addType(AccidentType accidentType) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbc.update("insert into accidenttype (name) values (?)",
                accidentType.getName()
                , keyHolder);
        accidentType.setId((Integer) keyHolder.getKey());
        return accidentType;
    }

    public Rule addRule(Rule rule) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbc.update("insert into rule (name) values (?)",
                rule.getName()
                , keyHolder);
        rule.setId((Integer) keyHolder.getKey());
        return rule;
    }

    public Accident getID(Integer id) {
        Accident accidentout = jdbc.queryForObject("select id, name, text, address, type_id from accident where id = ?",
                (rs, row) -> {
                    Accident accident = new Accident();
                    accident.setId(rs.getInt("id"));
                    accident.setName(rs.getString("name"));
                    accident.setText(rs.getString("text"));
                    accident.setAddress(rs.getString("address"));
                    AccidentType accidentType = new AccidentType();
                    accidentType.setId(rs.getInt("type_id"));
                    accident.setType(accidentType);
                    return accident;
                },id);
        AccidentType accidentType = this.getTypeID(accidentout.getType().getId());
        accidentout.setType(accidentType);
        List<Rule> ruleout = jdbc.query("select id , name " +
                        "from rule_accident " +
                        "inner join rule" +
                        " on id = rule_id " +
                        "where accident_id = ?",
                (rs, row) -> {
                    Rule rule = new Rule();
                    rule.setId(rs.getInt("id"));
                    rule.setName(rs.getString("name"));
                    return rule;
                },id);
        accidentout.setRules(new HashSet<>(ruleout));
        return accidentout;
    }

    public AccidentType getTypeID(Integer id) {
        AccidentType accidentTypeout = jdbc.queryForObject("select id, name from accidenttype where id = ?",
                (rs, row) -> {
                    AccidentType accidentType = new AccidentType();
                    accidentType.setId(rs.getInt("id"));
                    accidentType.setName(rs.getString("name"));
                    return accidentType;
                },id);
        return accidentTypeout;
    }

    public Rule getRuleID(Integer id) {
        Rule ruleout = jdbc.queryForObject("select id, name from rule where id = ?",
                (rs, row) -> {
                    Rule rule = new Rule();
                    rule.setId(rs.getInt("id"));
                    rule.setName(rs.getString("name"));
                    return rule;
                },id);
        return ruleout;
    }

    public Collection<Accident> getAccidents() {
        List<Accident> accidents = jdbc.query("select id from accident",
                (rs, row) -> {
                    Accident accident = new Accident();
                    accident.setId(rs.getInt("id"));
                    return accident;
                });
        for (int i = 0; i < accidents.size(); i++) {
            accidents.set(i, this.getID(accidents.get(i).getId()));
        }

        return accidents;
    }

    public Collection<AccidentType> getAccidentTypes() {
        List<AccidentType> accidentTypes = jdbc.query("select id, name from accidenttype ",
                (rs, row) -> {
                    AccidentType accidentType = new AccidentType();
                    accidentType.setId(rs.getInt("id"));
                    accidentType.setName(rs.getString("name"));
                    return accidentType;
                });
        return accidentTypes;
    }

    public Collection<Rule> getRules() {
        List<Rule> rules = jdbc.query("select id, name from rule ",
                (rs, row) -> {
                    Rule rule = new Rule();
                    rule.setId(rs.getInt("id"));
                    rule.setName(rs.getString("name"));
                    return rule;
                });
        return rules;
    }
}
