package com.buchhandlung.demo.buchhandlung;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BuchService {

    @Autowired
    private BuchRepo buchRepo;

    public Buch createBuch(Buch newBuch) {
        return this.buchRepo.save(newBuch);
    }


    public Buch getBuch(int id) {

        return this.buchRepo.findById(id).get();
    }

    public Buch updateBuch(int id, Buch updatedBuch) {
        Buch buchfromDB = buchRepo.findById(id).get();

        buchfromDB.setName(updatedBuch.getName());
        buchfromDB.setPreis(updatedBuch.getPreis());
        buchfromDB.setAutor(updatedBuch.getAutor());

        return buchRepo.save(buchfromDB);
    }

    public Buch removeBuch(int id) {
        Buch deletedBuch = this.buchRepo.findById(id).get();
        this.buchRepo.deleteById(id);
        return deletedBuch;
    }

    public List<Buch> getAllBuch() {
        List<Buch> buchList = new ArrayList<>();
        this.buchRepo.findAll().forEach(buch -> buchList.add(buch) );
        return buchList;
    }
}
