package com.movie.action;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.movie.pojo.Movies;
import com.movie.pojo.QueryMovie;
import com.movie.service.IMovieService;

@Controller
@RequestMapping("/movie")
public class MovieAction {
	@Resource(name = "movieService")
	private IMovieService movieService;

	@RequestMapping("/getAllMovie")
	public ModelAndView getAllMovie(@ModelAttribute QueryMovie queryMovie, HttpServletRequest request,
			HttpServletResponse response) {
		if (queryMovie.getPageNo() < 1 || queryMovie == null) {
			queryMovie.setPageNo(1);
		}

		try {
			ModelAndView mv = new ModelAndView();
			int totalCount = movieService.getCount(queryMovie);
			if ((int) Math.ceil((float) totalCount / 4) < queryMovie.getPageNo()) {
				queryMovie.setPageNo(1);
			}
			mv.addObject("movieList", movieService.getAllMovies(queryMovie));
			mv.addObject("timeList", movieService.timesMovies());
			mv.addObject("totalCount", totalCount);
			mv.addObject("totalPage", (int) Math.ceil((float) totalCount / 4));
			mv.setViewName("index");
			return mv;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@RequestMapping("/toAddMovie")
	public String toAddMovie() {
		return "movie/addMovie";
	}

	@RequestMapping("/getMovie")
	public String getMovie(String id, HttpServletRequest request) {
		request.setAttribute("movies", movieService.getMovies(id));
		return "movie/get";
	}

	@RequestMapping("/findsMovie")
	public String findsMovie(String id, HttpServletRequest request) {
		request.setAttribute("movies", movieService.getMovies(id));
		return "movie/find";
	}

	@RequestMapping(value = "/addMovie", method = RequestMethod.POST)
	public String addMovie(Movies movies) {
		movies.setMovieTime(new Date());
		movieService.addMovies(movies);
		return "redirect:/movie/getAllMovieList";
	}

	@RequestMapping("/getAllMovieList")
	public ModelAndView getAllMovieList(@ModelAttribute QueryMovie queryMovie, HttpServletRequest request,
			HttpServletResponse response) {
		if (queryMovie.getPageNo() < 1 || queryMovie == null) {
			queryMovie.setPageNo(1);
		}

		try {
			ModelAndView mv = new ModelAndView();

			int totalCount = movieService.getCount(queryMovie);
			if ((int) Math.ceil((float) totalCount / 4) < queryMovie.getPageNo()) {
				queryMovie.setPageNo(1);
			}
			mv.addObject("movieList", movieService.getAllMovies(queryMovie));
			mv.addObject("totalCount", totalCount);
			mv.addObject("totalPage", (int) Math.ceil((float) totalCount / 4));
			mv.setViewName("movie/homepage");
			return mv;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@RequestMapping("/delMovie")
	public String delMovie(String id) {
		movieService.delMovies(id);
		return "redirect:/movie/getAllMovieList";
	}

	@RequestMapping("/playMovie")
	public ModelAndView playMovies(@ModelAttribute QueryMovie queryMovie, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			ModelAndView mv = new ModelAndView();
			mv.addObject("playList", movieService.playMovies());
			mv.setViewName("movie/movieType");
			return mv;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@RequestMapping("/terrorMovie")
	public ModelAndView terrorMovies(@ModelAttribute QueryMovie queryMovie, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			ModelAndView mv = new ModelAndView();

			mv.addObject("terrorList", movieService.terrorMovies());

			mv.setViewName("movie/movieType1");
			return mv;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@RequestMapping("/comedyMovie")
	public ModelAndView comedyMovies(@ModelAttribute QueryMovie queryMovie, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			ModelAndView mv = new ModelAndView();
			mv.addObject("comedyList", movieService.comedyMovies());
			mv.setViewName("movie/movieType2");
			return mv;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@RequestMapping("/loveMovie")
	public ModelAndView loveMovies(@ModelAttribute QueryMovie queryMovie, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			ModelAndView mv = new ModelAndView();

			mv.addObject("loveList", movieService.loveMovies());

			mv.setViewName("movie/movieType3");
			return mv;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@RequestMapping("/scienceMovie")
	public ModelAndView scienceMoviesMovies(@ModelAttribute QueryMovie queryMovie, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			ModelAndView mv = new ModelAndView();
			mv.addObject("scienList", movieService.scienceMovies());
			mv.setViewName("movie/movieType4");
			return mv;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@RequestMapping("/exploreMovie")
	public ModelAndView exploreMovies(@ModelAttribute QueryMovie queryMovie, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			ModelAndView mv = new ModelAndView();
			mv.addObject("exploreList", movieService.exploreMovies());
			mv.setViewName("movie/movieType5");
			return mv;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
}
