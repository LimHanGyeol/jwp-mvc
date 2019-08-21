package core.mvc.tobe;

import core.annotation.web.*;
import core.di.factory.example.MockView;
import core.mvc.view.ModelAndView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class TestUserController {
    private static final Logger logger = LoggerFactory.getLogger(TestUserController.class);

    @RequestMapping(value = "/users/string", method = RequestMethod.POST)
    public ModelAndView create_string(String userId, String password) {
        logger.debug("userId: {}, password: {}", userId, password);
        ModelAndView mav = new ModelAndView(new MockView());
        mav.addObject("userId", userId);
        mav.addObject("password", password);
        return mav;
    }

    @RequestMapping(value = "/users/primitive", method = RequestMethod.POST)
    public ModelAndView create_int_long(long id, int age) {
        logger.debug("id: {}, age: {}", id, age);
        ModelAndView mav = new ModelAndView(new MockView());
        mav.addObject("id", id);
        mav.addObject("age", age);
        return mav;
    }

    @RequestMapping(value = "/users/object", method = RequestMethod.POST)
    public ModelAndView create_javabean(TestUser testUser) {
        logger.debug("testUser: {}", testUser);
        ModelAndView mav = new ModelAndView(new MockView());
        mav.addObject("testUser", testUser);
        return mav;
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public ModelAndView show_pathvariable(@PathVariable long id) {
        logger.debug("userId: {}", id);
        ModelAndView mav = new ModelAndView(new MockView());
        mav.addObject("id", id);
        return mav;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView show_requestParam(@RequestParam long id) {
        logger.debug("userId: {}", id);
        ModelAndView mav = new ModelAndView(new MockView());
        mav.addObject("id", id);
        return mav;
    }
}
