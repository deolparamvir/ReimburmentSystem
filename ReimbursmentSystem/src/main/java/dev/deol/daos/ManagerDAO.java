package dev.deol.daos;

import dev.deol.entities.Manager;

public interface ManagerDAO {
	Manager loginManager(String username, String password);
}
