package com.example.PrescriptionCRUD.services;

import com.example.PrescriptionCRUD.dtos.UserDTO;
import com.example.PrescriptionCRUD.entities.User;
import com.example.PrescriptionCRUD.entities.UserType;
import com.example.PrescriptionCRUD.mappers.UserMapper;
import com.example.PrescriptionCRUD.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PatientService patientService;
    private final DoctorService doctorService;

    @Transactional
    public void createUser(UserDTO userDTO){
        Optional<User> optionalUser = userRepository.findByPesel(userDTO.getPesel());
        if (optionalUser.isEmpty()){
            if (UserType.DOCTOR.equals(userDTO.getUserType())){
                doctorService.addNewDoctor(UserMapper.INSTANCE.userDTOtoDoctorDTO(userDTO));
            } else {
                patientService.addPatient(UserMapper.INSTANCE.userDTOtoPatientDTO(userDTO));
            }
            User user = UserMapper.INSTANCE.userDTOtoUser(userDTO);
            userRepository.save(user);
        } else {
            throw new IllegalStateException("User already exists in database!");
        }
    }

    // tylko dla admina
    public Long getUserId(String userPesel){
        User user = userRepository.findByPesel(userPesel)
                .orElseThrow(() -> new IllegalStateException("User does not exist in database."));
        return user.getId();
    }

    // tylko dla admina
    @Transactional
    public void deleteUser(Long userId){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException("User does not exist in database."));

        userRepository.deleteById(userId);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository
                .findByPesel(username)
                .orElseThrow(()->new IllegalStateException("Username " + username + " does not exist in database."));
    }
}
