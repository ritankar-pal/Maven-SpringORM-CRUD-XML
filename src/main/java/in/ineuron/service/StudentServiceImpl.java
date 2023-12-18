package in.ineuron.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.bo.StudentBO;
import in.ineuron.dao.IStudentDao;
import in.ineuron.dto.StudentDTO;


@Service
@Transactional
public class StudentServiceImpl implements IStudentService {
	
	@Autowired
	private IStudentDao dao;

	@Override
	public int insert(StudentDTO dto) {
		StudentBO bo = new StudentBO();
		BeanUtils.copyProperties(dto, bo);
		
		return dao.insert(bo);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(StudentDTO s) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(StudentDTO s) {
		// TODO Auto-generated method stub

	}

	@Override
	public StudentDTO getStudent(int id) {
		StudentBO bo = dao.getStudent(id);
		StudentDTO dto = new StudentDTO();
		BeanUtils.copyProperties(bo, dto);
		return dto;
	}

	@Override
	public List<StudentDTO> getAllStudents() {
		
		List<StudentBO> bo = dao.getAllStudents();
		
		List<StudentDTO> listDTO = new ArrayList<>();
		
		bo.forEach(std -> {
			StudentDTO dto = new StudentDTO();
			BeanUtils.copyProperties(std, dto);
			listDTO.add(dto);
		});
		
		return listDTO;
	}

	@Override
	public String toString() {
		return "StudentServiceImpl [dao=" + dao + "]";
	}

}
