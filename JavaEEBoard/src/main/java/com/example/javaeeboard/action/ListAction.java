package com.example.javaeeboard.action;

import com.example.javaeeboard.Controller.CommandAction;
import com.example.javaeeboard.beans.board;
import com.example.javaeeboard.dao.BoardDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;

public class ListAction implements CommandAction {
    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        request.setCharacterEncoding("utf-8");
        String search = request.getParameter("search");

        int page = 0 ;
        if(request.getParameter("page")!=null){
            page=Integer.parseInt(request.getParameter("page"));
        }
        ArrayList<board> boardList = BoardDao.getInstance().getBoardList(search,page);
        ArrayList<board> maxList = BoardDao.getInstance().getSearchList(search);

        request.setAttribute("boardList", boardList);
        request.setAttribute("page", page);
        request.setAttribute("maxList", maxList);

        int totalPages= maxList.size()/10 + 1;
        int pageBlock = 3; //블럭의 수 1, 2, 3
        int startBlockPage = ((page/10)/pageBlock)*pageBlock; //현재 페이지가 7이라면 7/3 * 3 + 1
        int endBlockPage = startBlockPage+pageBlock-1; //7+3-1=9. 7,8,9해서 9
        endBlockPage= totalPages<endBlockPage? totalPages:endBlockPage;

        request.setAttribute("startBlockPage", startBlockPage);
        request.setAttribute("endBlockPage", endBlockPage);

        return "list.jsp";
    }
}
