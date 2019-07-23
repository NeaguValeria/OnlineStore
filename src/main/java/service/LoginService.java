package service;

import javafx.application.Application;
import model.User;
import utils.AplicationConst;
import utils.TxtFileReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LoginService {

    public User login(String userID, String password) {
        User user = null;
        TxtFileReader txtFileReader = new TxtFileReader(AplicationConst.USERS_FILE_PATH);
        ArrayList<String> lines = txtFileReader.read();
        for (String line : lines) {
            String[] tokens = line.split(" ");
            if (tokens.length != 2) {
                continue;
            }
            String fileId = tokens[0];
            String filePassword = tokens[1];
            if (userID.equals(fileId) && password.equals(filePassword)) {
                Map<String, Integer> products = new HashMap<String, Integer>();
                user = new User(userID,password,products);
            }
        }
        return user;
    }

}
