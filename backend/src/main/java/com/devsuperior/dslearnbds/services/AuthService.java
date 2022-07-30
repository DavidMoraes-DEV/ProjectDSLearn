package com.devsuperior.dslearnbds.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslearnbds.entities.User;
import com.devsuperior.dslearnbds.repositories.UserRepository;
import com.devsuperior.dslearnbds.services.exceptions.ForbiddenException;
import com.devsuperior.dslearnbds.services.exceptions.UnauthorizedException;

@Service
public class AuthService {

	@Autowired
	private UserRepository userRepository;
	
	@Transactional(readOnly = true)
	public User authenticated() {
		try {
		
			//Chamada que pega o nome do usuário que já foi reconhecido pelo Spring Secutiry
			String username = SecurityContextHolder.getContext().getAuthentication().getName();
			return userRepository.findByEmail(username);
		
		} catch (Exception e) {
			throw new UnauthorizedException("Invalid User");
		}
	}
	
	//Verifica se o id do usuário é dele próprio ou o id é de algum usuário com o perfil de Admin, pois o usuário pode buscar apenas seu próprio id e apenas os usuário Admin podem buscar todos os id dos usuários
	public void validateSelfOrAdmin(Long id) {
		User user = authenticated();
		
		//Verifica se o id buscado NÃO é igual ao id do usuário logado && se o usuário logado é ADMIN e NÃO for nenhum dos dois então é um usuário STUDENT que não possui autorização para buscar ids de outros usuários
		if (!user.getId().equals(id) && !user.hasRole("ROLE_ADMIN")) {
			throw new ForbiddenException("Access denied");
		}
	}
}
