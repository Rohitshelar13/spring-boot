//package com.cts.employeeTravelDesk.TravelPlanner.Service;
//
//
//import java.util.HashSet;
//import java.util.Set;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.DisabledException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.cts.employeeTravelDesk.TravelPlanner.dao.UserRepository;
//import com.cts.employeeTravelDesk.TravelPlanner.entities.JwtRequest;
//import com.cts.employeeTravelDesk.TravelPlanner.entities.JwtResponse;
//import com.cts.employeeTravelDesk.TravelPlanner.entities.User;
//import com.cts.employeeTravelDesk.TravelPlanner.util.JwtUtil;
//
//@Service
//public class JwtService implements UserDetailsService{
//	@Autowired
//	private UserRepository userDao;
//	
//	@Autowired
//	private JwtUtil jwtUtil;
//	
//	@Autowired
//	private User users;
//	
//	@Autowired
//	private AuthenticationManager authenticationManager;
//	
//	public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception{
//		String userName = jwtRequest.getUserName();
//		int employeeId = users.getEmployeeId();
//		String userPassword = jwtRequest.getUserPassword();
//		authenticate(userName, userPassword);
//		final UserDetails userDetails = loadUserByUsername(userName);
//		
//		String newGeneratedToken = jwtUtil.generateToken(userDetails);
//		
//		User user = userDao.findById(employeeId).get();
//		return new JwtResponse(user, newGeneratedToken);
//	}
//	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
//		int employeeId = users.getEmployeeId();
//		User user = userDao.findById(employeeId).get();
//		if(user!=null) {
//			return new org.springframework.security.core.userdetails.User(
//					user.getEmailAddress(),
//					user.getPassword(),
//					getAuthorities(user)
//					);
//		}
//		else {
//			throw new UsernameNotFoundException("Username not valid");
//		}
//	}
//	private Set getAuthorities(User user) {
//		Set authorities = new HashSet();
//		authorities.add(new SimpleGrantedAuthority("ROLE_"+user.getRole().getRoleName()));
//		return authorities;
//		
//	}
//	
//	private void authenticate(String userName, String userPassword) throws Exception{
//		try {
//			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, userPassword));
//		} catch(DisabledException e) {
//			throw new Exception("User is disabled");
//		} catch(BadCredentialsException e) {
//			throw new Exception("Bad Credentials Exception");
//		}
//		
//	}
//}
