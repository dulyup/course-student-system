package org.lyup.coursesystem.courseweb.manager.impl;


import org.lyup.coursesystem.courserservice.model.Program;
import org.lyup.coursesystem.courserservice.service.ProgramService;
import org.lyup.coursesystem.courserservice.service.impl.ProgramServiceImpl;
import org.lyup.coursesystem.courseweb.manager.ProgramManager;

import java.util.ArrayList;
import java.util.List;

public class ProgramManagerImpl implements ProgramManager{

    private ProgramService programService = new ProgramServiceImpl();
//    private StudentService studentService = new StudentServiceImpl();
//    private CourseService courseService = new CourseServiceImpl();

    @Override
    public List<Program> listAllPrograms() {
        return programService.listAllPrograms();
    }

    @Override
    public Program getProgramById(String id) {
        return programService.getProgramById(id);
    }

    @Override
    public Boolean addProgram(Program program) {
        return programService.addProgram(program);
    }

    @Override
    public Boolean updateProgram(String id, Program program) {
        return programService.updateProgram(id, program);
    }

    @Override
    public Boolean removeProgramById(String id) {
        return programService.removeProgramById(id);
    }

//    @Override
//    public List<Course> listProgramCoursesByProgramId(String id) {
//        List<Course> programCourseList = new ArrayList<>();
//        Set<String> courseIdSet = programService.getProgramById(id).getCourseSet();
//        for (String courseId: courseIdSet) {
//            programCourseList.add(courseService.getCourseById(courseId));
//        }
//        return programCourseList;
//    }
//
//    @Override
//    public List<Student> listProgramStudentsByProgramId(String id) {
//        List<Student> programStudentList = new ArrayList<>();
//        List<Student> allStudentList = studentService.listAllStudents();
//        for (Student student: allStudentList) {
//            if (id.equals(student.getProgramId())) {
//                programStudentList.add(student);
//            }
//        }
//        return programStudentList;
//    }
//
//    @Override
//    public Boolean addProgramCourseByProgramIdAndCourseId(String id, String courseId) {
//        programService.getProgramById(id).getCourseSet().add(courseId);
//        return true;
//    }
//
//    @Override
//    public Boolean removeProgramCourseByProgramIdAndCourseId(String id, String courseId) {
//        programService.getProgramById(id).getCourseSet().remove(courseId);
//        return true;
//    }
}
