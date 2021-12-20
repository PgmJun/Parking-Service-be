package jh.ParkingService.service.user;

import jh.ParkingService.domain.user.User;
import jh.ParkingService.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Primary
@Transactional
public class UserServiceImpl {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //user데이터 DB에 저장
    public void join(User user){
        userRepository.save(user);
    }
/*
    //중복데이터 저장 방지
    private void validateDuplicateMember(User user){
        userRepository.findByEmail(user.getEmail())
                .ifPresent(e -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
*/

    //email주소로 db에서 유저데이터 검색
    public Optional<User> findUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public List<User> findUsers(){
        return userRepository.findAll();
    }
}
