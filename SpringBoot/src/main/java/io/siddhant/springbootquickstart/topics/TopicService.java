package io.siddhant.springbootquickstart.topics;

import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class TopicService {

	List<Topic> topics = new ArrayList( Arrays.asList(
			new Topic("spring", "Spring Framework", "Spring Framework Description"),
			new Topic("java", "Core Java", "Core Java Description"),
			new Topic("python", "Django", "Machine Learning"),
			new Topic("c++", "STL", "Competitive Programming")
			)
			);
	

	public List<Topic> getAllTopics(){
		return topics;
	}
	public Topic getTopic(String id)
	{
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}
	public void addTopic( Topic topic)
	{
		topics.add(topic);
	}
	public void updateTopic(String id, Topic topic)
	{

		for (int i = 0; i< topics.size();i++)
		{
			Topic t = topics.get(i);
	
			if (t.id.equalsIgnoreCase(topic.id))  {

				t.setId(topic.id);
				t.setName(topic.name);
				t.setDescription(topic.description);

				System.out.println(topics);
			return;	
			}
		}	

		
		
	}
}
