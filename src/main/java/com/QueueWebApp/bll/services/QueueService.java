package com.QueueWebApp.bll.services;

import com.QueueWebApp.models.Subject;
import com.QueueWebApp.models.User;
import com.QueueWebApp.repo.QueueRepository;
import com.QueueWebApp.repo.SubjectRepository;
import com.QueueWebApp.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

@Service
public class QueueService {
	private final QueueRepository queueRepository;

	private static final Map<Long, List<User>> usersQueueMap = new HashMap<>();
	@Autowired
	public QueueService(QueueRepository queueRepository) {
		this.queueRepository = queueRepository;
	}

	public QueueRepository GetQueueRepository() {
		return this.queueRepository;
	}

	public List<User> GetFinalUsersQueueList(Subject subject) {
		String curDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		String subDate = subject.getDate().toString();
		Long subjectId = subject.getId();

		int currentDate = Integer.parseInt(curDate.replace("-", ""));
		int subjectDate = Integer.parseInt(subDate.replace("-", ""));

		if(currentDate > subjectDate) {
			try {
				usersQueueMap.remove(subject.getId());
			}
			catch(Exception e){
				e.getStackTrace();
			}
			return null;
		}

		if(currentDate != subjectDate) {
			return null;
		}

		if(usersQueueMap.containsKey(subjectId)) {
			return usersQueueMap.get(subjectId);
		}

		List<User> usersList = queueRepository.GetUsersBySubjectId(subject.getId());
		Collections.shuffle(usersList);

		usersQueueMap.put(subjectId, usersList);

		return usersList;
	}
}
