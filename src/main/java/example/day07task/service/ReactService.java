package example.day07task.service;

import example.day07task.model.ReactMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReactService {
    @Autowired
    private ReactMapper reactMapper;

    public boolean onPost(Map<Object,String> map){
        return reactMapper.onPost(map);
    }
    public List<Map<Object,String>> onFindAll(){
        return reactMapper.onFindAll();
    }
}
