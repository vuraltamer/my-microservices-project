
package com.project.data.repo;

import com.project.data.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User, String>
{

	
}
