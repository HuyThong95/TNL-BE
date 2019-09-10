package com.codegym.tnlbe.security.services;

import com.codegym.tnlbe.entity.LandLord;
import com.codegym.tnlbe.repository.LandLordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LandLordDetailsServiceImpl implements UserDetailsService {
    @Autowired
    LandLordRepository landLordRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LandLord landLord = landLordRepository.findByName(username).orElseThrow(() -> new UsernameNotFoundException("User Not Found with -> username or email : " + username));
        return LandLordPrinciple.build(landLord);
    }
}
