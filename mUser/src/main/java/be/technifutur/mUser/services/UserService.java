package be.technifutur.mUser.services;

import be.technifutur.mUser.dtos.UserDto;
import be.technifutur.mUser.entities.User;
import be.technifutur.mUser.mapper.Mapper;
import be.technifutur.mUser.repositories.UserRepository;
import be.technifutur.mUser.utils.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final Mapper mapper;
    private final UserRepository userRepository;

    public UserService(Mapper mapper, UserRepository userRepository) {
        this.mapper = mapper;
        this.userRepository = userRepository;
    }

    public List<UserDto> getAllUsers() {
        return this.userRepository.findAll()
                .stream()
                .map(this.mapper::toUserDto)
                .collect(Collectors.toList())
                ;
    }

    public UserDto getUserById(int id) throws UserNotFoundException {
        User user = this.userRepository.findById(id).orElseThrow(
                () -> new UserNotFoundException("User #" + id + " n'a pas pu être trouvé")
        );
        return this.mapper.toUserDto(user);
    }

    public UserDto getUserByPseudoAndPassword(String pseudo, String password) throws UserNotFoundException {
        User user = this.userRepository.findByPseudoAndPassword(pseudo, password).orElseThrow(
                () -> new UserNotFoundException("User " + pseudo + " n'a pas pu être trouvé")
        );
        return this.mapper.toUserDto(user);
    }

    public void insertUser(User user) {
        this.userRepository.save(user);
    }
}
