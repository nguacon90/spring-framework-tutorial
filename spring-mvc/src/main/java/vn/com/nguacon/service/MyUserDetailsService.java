package vn.com.nguacon.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import vn.com.nguacon.dao.UserDao;
import vn.com.nguacon.model.MyUser;

@Service
public class MyUserDetailsService implements UserDetailsService {

	private UserDao userDao;

	@Autowired
	public MyUserDetailsService(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MyUser user = userDao.findByUsername(username);
		List<GrantedAuthority> authorities = buildUserAuthority(user.getRoles());
		return new User(user.getUsername(), user.getPassword(),
				authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(List<String> roles) {

		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

		// Build user's authorities
		for (String role : roles) {
			setAuths.add(new SimpleGrantedAuthority(role));
		}

		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

		return Result;
	}

}
