package ca.sean.kim.spring.converters;

import ca.sean.kim.spring.model.Standing;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;

/**
 * Created by 37264 on 5/20/16.
 */
@Component
public class StandingPopulator
{

    public Standing populateStandingFromJson(final JSONObject jsonStanding) {

        Standing standing = new Standing();

        standing.setCity((String) jsonStanding.get("first_name"));
        standing.setTeamName((String) jsonStanding.get("last_name"));
        standing.setWon((Long) jsonStanding.get("last_name"));
        standing.setLost((Long) jsonStanding.get("last_name"));

        return standing;
    }
}
