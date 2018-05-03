package com.movie.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.movie.pojo.QueryMovie;
import com.movie.pojo.Record;
import com.movie.pojo.User;
import com.movie.service.IRecordService;

@Controller
@RequestMapping("/record")
public class RecordAction {
	@Resource(name = "recordService")
	private IRecordService recordService;

	@RequestMapping("/getAllRecord")
	public ModelAndView getAllRecord(@ModelAttribute QueryMovie queryMovie, HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("loginUser");
		System.out.println(user.getId());
		 queryMovie.setUserId(user.getId());
		ModelAndView mv = new ModelAndView();
		try {
			mv.addObject("recordList", recordService.getAllRecord(queryMovie));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mv.setViewName("record/list");
		return mv;
	}

	@RequestMapping("/addRecord")
	public String addRecord(Record record)throws Exception {
			if(recordService.GET(record.getMoviesId()).size()==0){
				recordService.addRecord(record);
				return "login";
				
			}else{  
	    		return "login";
	        }  
		
	}
    @RequestMapping("/getRecord")
    public String getRecord(String id,HttpServletRequest request){
    	request.setAttribute("record",recordService.getRecord(id) );
    	return "record/get";
    }
    @RequestMapping("/delRecord")
    public String delRecord(String id){
    	recordService.delRecord(id);
    	return "redirect:/record/getAllRecord";
    }
}
