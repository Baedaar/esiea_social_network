package fr.rana.baedaar.services;

import fr.rana.baedaar.entities.User;

public interface AuthenticationService {

    User connection(String userName, String password);
}
