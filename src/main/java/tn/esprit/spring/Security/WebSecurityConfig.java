package tn.esprit.spring.Security;

public class WebSecurityConfig { //extends WebSecurityConfigurerAdapter{
	
	//@Autowired
	//private MyUserDetailsService userDetailsService;
	//@Override
	//protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	//BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	//auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);}
	//@Override
	//protected void configure(HttpSecurity http) throws Exception {
	//http.authorizeRequests() .antMatchers("/retrieve-synonyms/{word}").permitAll();
	//.antMatchers("/getRevenuBrutProduit/{idProduit}/{startDate}/{endDate}").access("hasRole('SUPERADMIN')")
	//.antMatchers("/get**}").access("hasRole('ADMIN')")
	//.antMatchers("/retrieve-all-clients").access("hasRole('ADMIN')")
	//.anyRequest()
	//.authenticated()
	//.and()
	//.httpBasic().and().csrf().disable();
	//}

}
