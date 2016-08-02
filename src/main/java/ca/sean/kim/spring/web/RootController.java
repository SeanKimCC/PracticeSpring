package ca.sean.kim.spring.web;

/**
 * Created by 37264 on 5/18/16.
 */

import ca.sean.kim.spring.service.StandingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

//import java.net.URL;


@Controller
public class RootController {
    //static final Logger logger = Logger.getLogger( RootController.class );

    @Autowired
    private StandingService standingService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public  ModelAndView handleRootGetRequest() throws Exception {
        //logger.debug( "Called" );
        ModelAndView mav = new ModelAndView();
       //mav.setViewName("redirect:/index.html");


        return mav;

    }

    /**
     * @return
     */
    //@Secured("ROLE_USER")
    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public ModelAndView handleHomeGetRequest() throws Exception {
        //logger.debug( "Called" );

        standingService.executeGet("https://erikberg.com/mlb/standings.json");

        return null;
    }
}