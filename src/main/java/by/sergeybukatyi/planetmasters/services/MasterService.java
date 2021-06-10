package by.sergeybukatyi.planetmasters.services;

import by.sergeybukatyi.planetmasters.entities.Master;
import by.sergeybukatyi.planetmasters.repositories.MasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class MasterService {
    final
    MasterRepository masterRepository;

    @Autowired
    public MasterService(MasterRepository masterRepository) {
        this.masterRepository = masterRepository;
    }


    public String saveMaster(String name, int age) {
        if(!name.equals("") ){
            if(age <= 0){
                return "Age cannot be 0 or less!";
            }
            Master master = new Master(name, age);
            try {
                masterRepository.save(master);
                return master.getName() + " saved!";
            }catch (DataIntegrityViolationException e){
                return master.getName() + " already exists!";
            }
        }
        else {
            return "Master name cannot be empty!";
        }
    }

    public List<Master> getAll() {
        return (List<Master>) masterRepository.findAll();
    }

    public Master getMasterByName(String name) {
        return masterRepository.findByName(name);
    }


    public List<Master> getMastersWithoutPlanets() {
        return masterRepository.get();
    }

    public List<Master> getTenYoungestMasters() {
        Pageable topTen = PageRequest.of(0, 10);
        return masterRepository.findTop10ByOrderByAgeAsc(topTen);
    }

}
