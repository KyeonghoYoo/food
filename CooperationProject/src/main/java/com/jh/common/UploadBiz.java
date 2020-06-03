package com.jh.common;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class UploadBiz {

	private static final Logger logger = LoggerFactory.getLogger(UploadBiz.class);

	// Ajax 파일 업로드 produces는 한국어를 정상적으로 전송하기 위한 속성
	public void uploadAjaxPOST(MultipartFile file, Object id, String path) throws Exception {

		//이미지가 존재하는 지
		if (!file.isEmpty()) {
			file.transferTo(new File(StaicKeyWord.IMAGE_PATH+path, id+StaicKeyWord.EXTENSION_IMAGE_JPG));
		}
	}

	// 업로드된 파일 삭제 처리
	public void deleteFile(String fileName, String path) throws Exception {
		File file = new File(StaicKeyWord.IMAGE_PATH + path + fileName + StaicKeyWord.EXTENSION_IMAGE_JPG);
		file.delete();
		logger.info("delete file:" + fileName);
	}
	public void updateFile(MultipartFile file, String id, String path)  {
		try {
			deleteFile(id, path);
			uploadAjaxPOST(file, id, path);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
