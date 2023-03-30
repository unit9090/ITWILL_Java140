package edu.java.contact05;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import edu.java.contact.fileutil.FileUtil;
import edu.java.contact.model.Contact;

// MVC(Model-View-Controller) 아키텍쳐 컨트롤러 구현 클래스.
// singleton 디자인 패턴을 적용.

public class ContactDaoImpl implements ContactDao {
	// singleton step 1
	private static ContactDaoImpl instance = null;
	
	// singleton step 2
	private ContactDaoImpl() {
		dataDir = FileUtil.initDataDir();
		dataFile = new File(FileUtil.DATA_DIR, FileUtil.DATA_FILE);
		contacts = FileUtil.initData();
	};
	
	// TODO: ContactDaoImpl에는 연락처 데이터를 변경하는 메서드들이 있음.
	// -> 연락처 데이터가 변경되는 메서드에서 FileUtil.writeDataToFile() 메서드 호출.
	
	
	
	// singleton step 3
	public static ContactDaoImpl getInstance() {
		if(instance == null) {
			instance = new ContactDaoImpl();
		}
		
		return instance;
	}
	
	// fields
	private List<Contact> contacts;	// 연락처 데이터
	private File dataDir;	// 연락처 데이터 파일을 저장할 폴더
	private File dataFile;	// 연락처 데이터 파일
	
	// methods
	/**
	 * 어떤 인덱스가 검색, 수정, 삭제할 때 사용 가능한 범위 안에 있는 인덱스인 지를 리턴.
	 * @param index 유효한 인덱스인 지 검사할 인덱스.
	 * @return 사용가능한 인덱스는 true, 그렇지 않으면 false.
	 */
	public boolean isValidIndex(int index) {
		return (index >= 0) && (index < contacts.size());
	}
	
	// CRUD(Create, Read, Update, Delete) 기능 메서드들:
	@Override
	public int create(Contact c) {
		contacts.add(c);
		
		FileUtil.writeDataToFile(contacts, dataFile);
		
		return 1;
	}

	@Override
	public List<Contact> read() {
		
		return contacts;
//		return FileUtil.readDataFromFile(dataFile);
	}

	@Override
	public Contact read(int index) {
		if(!isValidIndex(index)) {
			return null;
		}
		
		return contacts.get(index);
	}

	@Override
	public int update(int index, Contact contact) {
		if(!isValidIndex(index)) {
			return 0;
		}
		
//		contacts.get(index).setName(contact.getName());
//		contacts.get(index).setPhone(contact.getPhone());
//		contacts.get(index).setEmail(contact.getEmail());
		
		contacts.set(index, contact);
		FileUtil.writeDataToFile(contacts, dataFile);
		
		return 1;
	}

	@Override
	public int delete(int index) {
		if(!isValidIndex(index)) {
			return 0;
		}
		
		contacts.remove(index);
		FileUtil.writeDataToFile(contacts, dataFile);
		
		return 1;
	}

}
