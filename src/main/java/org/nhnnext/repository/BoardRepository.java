package org.nhnnext.repository;

import java.util.List;

import org.nhnnext.web.Board;
import org.nhnnext.web.User;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends CrudRepository<Board, Long>{
	public List<Board> findByUser(User user);
}
