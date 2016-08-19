//
//  public class fsfsf {
//
//    private static final Logger logger = Logger.getLogger(fsfsf.class);
//    private Validation validation = new Validation();
//
//    @Autowired
//
//    private UserDAO userDAO;
//    @RequestMapping(value="/users", method = RequestMethod.GET)
//      public String listUsers(Model model) throws IOException {
//      logger.debug("listUsers() #### [ /users ] is executed!");
//        model.addAttribute("userDb", userDAO.list());
//        return "users";
//      }
//
//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public String showLogin(Model model) {
//      logger.debug("showLogin() #### [ /login ] is executed!");
//      model.addAttribute("userLogin", new User());
//      return "login";
//    }
//
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public String login(@ModelAttribute User userLogin, Model model) {
//      logger.debug("login() #### [ /login ] is executed!");
//      model.addAttribute("User", userLogin);
//      return validation.loginValidation(userLogin,userDAO);
//    }
//
//    @RequestMapping(value = "/registration", method = RequestMethod.GET)
//    public String showRegistrationForm(Model model) {
//      logger.debug("showRegistrationForm() #### [ /registration ] is executed!");
//      model.addAttribute("newUser", new User());
//      return "registration";
//    }
//
//    @RequestMapping(value = "/registration", method = RequestMethod.POST)
//    public String addNewUser(@Valid @ModelAttribute("newUser") User newUser, BindingResult bindingResult) {
//      logger.debug("addNewUser() #### [ /registration ] is executed!");
//      if (bindingResult.hasErrors()) {
//        logger.info("registration form had errors -----> redirect to [ /register ]");
//        return "registration";
//      } else {
//        logger.info("user saved ------> redirect to [ /welcome ]");
//        return validation.registrationValidation(newUser,userDAO);
//      }
//    }
//
//  @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
//  public ResponseEntity<String> deleteUser(@PathVariable("id") int id) {
//    logger.debug("deleteUser() #### [ /delete/" + id + " ] is executed!");
//    userDAO.delete(id);
//    return new ResponseEntity<>("Deleted!", HttpStatus.CREATED);
//  }
