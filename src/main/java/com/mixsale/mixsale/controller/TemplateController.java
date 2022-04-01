package com.mixsale.mixsale.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
//@RequestMapping("/student")
public class TemplateController {

//    private static final Logger log = LoggerFactory.getLogger(TemplateController.class);

//	@Autowired
//	StudentService studentService;

	@GetMapping("/test")
	public Object test(){
		return HttpStatus.OK;
	}
//	@GetMapping("/students")
//	public ResponseEntity<ResponseDto<StudentDto>> getAllStudents() throws Exception {
//		log.info("getAllStudents Start");
//		ResponseDto<StudentDto> response = new ResponseDto<>();
//		try {
//
//			List<StudentDto> students = studentService.getAllStudents();
//
//			if (CollectionUtils.isNotEmpty(students)) {
//				response.setData(students);
//				response.setResponseCode(ResponseDto.RESPONSE_CODE.SUCCESS01.getCode());
//				response.setResponseMessage(ResponseDto.RESPONSE_CODE.SUCCESS01.getValue());
//				response.setResponseStatus(ResponseDto.RESPONSE_STATUS.SUCCESS.getCode());
//			} else {
//				response.setResponseCode(ResponseDto.RESPONSE_CODE.SUCCESS02.getCode());
//				response.setResponseMessage(ResponseDto.RESPONSE_CODE.SUCCESS02.getValue());
//				response.setResponseStatus(ResponseDto.RESPONSE_STATUS.SUCCESS.getCode());
//			}
//
//		} catch (Exception e) {
//			response.setResponseCode(ResponseDto.RESPONSE_CODE.FAIL01.getCode());
//			response.setResponseMessage(ResponseDto.RESPONSE_CODE.FAIL01.getValue());
//			response.setResponseStatus(ResponseDto.RESPONSE_STATUS.FAIL.getCode());
//		}
//
//		log.info("getAllStudents End");
//		return new ResponseEntity<ResponseDto<StudentDto>>(response, HttpStatus.OK);
//	}
//
//	@GetMapping("/student/{citizen}")
//	public ResponseEntity<ResponseDto<StudentDto>> getStudentByCitizen(@PathVariable String citizen) throws Exception {
//		log.info("getStudentByCitizen Start");
//		ResponseDto<StudentDto> response = new ResponseDto<>();
//		try {
//
//			StudentDto students = studentService.getStudentByCitizen(citizen);
//
//			if (students != null) {
//				response.setData(Arrays.asList(students));
//				response.setResponseCode(ResponseDto.RESPONSE_CODE.SUCCESS01.getCode());
//				response.setResponseMessage(ResponseDto.RESPONSE_CODE.SUCCESS01.getValue());
//				response.setResponseStatus(ResponseDto.RESPONSE_STATUS.SUCCESS.getCode());
//			} else {
//				response.setResponseCode(ResponseDto.RESPONSE_CODE.SUCCESS02.getCode());
//				response.setResponseMessage(ResponseDto.RESPONSE_CODE.SUCCESS02.getValue());
//				response.setResponseStatus(ResponseDto.RESPONSE_STATUS.SUCCESS.getCode());
//			}
//
//		} catch (Exception e) {
//			response.setResponseCode(ResponseDto.RESPONSE_CODE.FAIL01.getCode());
//			response.setResponseMessage(ResponseDto.RESPONSE_CODE.FAIL01.getValue());
//			response.setResponseStatus(ResponseDto.RESPONSE_STATUS.FAIL.getCode());
//		}
//
//		log.info("getStudentByCitizen End");
//		return new ResponseEntity<ResponseDto<StudentDto>>(response, HttpStatus.OK);
//	}
//
//	@PostMapping("/student/save")
//	public ResponseEntity<ResponseDto<StudentDto>> saveStudent(@RequestBody StudentDto studentDto) throws Exception {
//		log.info("saveStudent Start");
//		ResponseDto<StudentDto> response = new ResponseDto<>();
//		try {
//
//			if (studentService.saveStudent(studentDto)) {
//				response.setResponseCode(ResponseDto.RESPONSE_CODE.SUCCESS01.getCode());
//				response.setResponseMessage(ResponseDto.RESPONSE_CODE.SUCCESS01.getValue());
//				response.setResponseStatus(ResponseDto.RESPONSE_STATUS.SUCCESS.getCode());
//			} else {
//				response.setResponseCode(ResponseDto.RESPONSE_CODE.SUCCESS02.getCode());
//				response.setResponseMessage(ResponseDto.RESPONSE_CODE.SUCCESS02.getValue());
//				response.setResponseStatus(ResponseDto.RESPONSE_STATUS.SUCCESS.getCode());
//			}
//
//		} catch (Exception e) {
//			response.setResponseCode(ResponseDto.RESPONSE_CODE.FAIL01.getCode());
//			response.setResponseMessage(ResponseDto.RESPONSE_CODE.FAIL01.getValue());
//			response.setResponseStatus(ResponseDto.RESPONSE_STATUS.FAIL.getCode());
//		}
//
//		log.info("saveStudent End");
//		return new ResponseEntity<ResponseDto<StudentDto>>(response, HttpStatus.OK);
//	}
//
//	@PostMapping("/student/update")
//	public ResponseEntity<ResponseDto<StudentDto>> updateStudent(@RequestBody StudentDto studentDto) throws Exception {
//		log.info("updateStudent Start");
//		ResponseDto<StudentDto> response = new ResponseDto<>();
//		try {
//
//			if (studentService.updateStudent(studentDto)) {
//				response.setResponseCode(ResponseDto.RESPONSE_CODE.SUCCESS01.getCode());
//				response.setResponseMessage(ResponseDto.RESPONSE_CODE.SUCCESS01.getValue());
//				response.setResponseStatus(ResponseDto.RESPONSE_STATUS.SUCCESS.getCode());
//			} else {
//				response.setResponseCode(ResponseDto.RESPONSE_CODE.SUCCESS02.getCode());
//				response.setResponseMessage(ResponseDto.RESPONSE_CODE.SUCCESS02.getValue());
//				response.setResponseStatus(ResponseDto.RESPONSE_STATUS.SUCCESS.getCode());
//			}
//
//		} catch (Exception e) {
//			response.setResponseCode(ResponseDto.RESPONSE_CODE.FAIL01.getCode());
//			response.setResponseMessage(ResponseDto.RESPONSE_CODE.FAIL01.getValue());
//			response.setResponseStatus(ResponseDto.RESPONSE_STATUS.FAIL.getCode());
//		}
//
//		log.info("updateStudent End");
//		return new ResponseEntity<ResponseDto<StudentDto>>(response, HttpStatus.OK);
//	}
//
//	@DeleteMapping("/student/{sId}")
//	public ResponseEntity<ResponseDto<StudentDto>> deleteStudent(@PathVariable Long sId) throws Exception {
//		log.info("deleteStudent Start");
//		ResponseDto<StudentDto> response = new ResponseDto<>();
//		try {
//
//			if (studentService.deleteStudent(sId)) {
//				response.setResponseCode(ResponseDto.RESPONSE_CODE.SUCCESS01.getCode());
//				response.setResponseMessage(ResponseDto.RESPONSE_CODE.SUCCESS01.getValue());
//				response.setResponseStatus(ResponseDto.RESPONSE_STATUS.SUCCESS.getCode());
//			} else {
//				response.setResponseCode(ResponseDto.RESPONSE_CODE.FAIL02.getCode());
//				response.setResponseMessage(ResponseDto.RESPONSE_CODE.FAIL02.getValue());
//				response.setResponseStatus(ResponseDto.RESPONSE_STATUS.FAIL.getCode());
//			}
//
//		} catch (Exception e) {
//			response.setResponseCode(ResponseDto.RESPONSE_CODE.FAIL01.getCode());
//			response.setResponseMessage(ResponseDto.RESPONSE_CODE.FAIL01.getValue());
//			response.setResponseStatus(ResponseDto.RESPONSE_STATUS.FAIL.getCode());
//		}
//
//		log.info("deleteStudent End");
//		return new ResponseEntity<ResponseDto<StudentDto>>(response, HttpStatus.OK);
//	}

}
