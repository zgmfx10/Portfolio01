package controllers;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Message;
import models.validators.MessageValidator;
import utils.DBUtil;
/**
 * Servlet implementation class CreateServlet
 */
@WebServlet("/create")
public class CreateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //CSRF対策のチェック
        String _token = request.getParameter("_token");
        if(_token != null && _token.equals(request.getSession().getId())) {
            //EntityManagerのオブジェクトを作成
            EntityManager em = DBUtil.createEntityManager();

            //mのインスタンスを作成
            Message m = new Message();

            //mの各フィールドにデータを代入
            String name = request.getParameter("name");
            m.setName(name);

            String hurigana = request.getParameter("hurigana");
            m.setHurigana(hurigana);

            String phone = request.getParameter("phone");
            m.setPhone(phone);

            String mail = request.getParameter("mail");
            m.setMail(mail);

            Timestamp currentTime = new Timestamp(System.currentTimeMillis());
            m.setCreated_at(currentTime);
            m.setUpdated_at(currentTime);

            //バリデーションを実行してエラーがあったら新規登録のフォームに戻る
            List<String> errors = MessageValidator.validate(m);
            if(errors.size() > 0) {
                em.close();

            //フォームに初期値を設定、さらにエラーメッセージを送る
            request.setAttribute("_token", request.getSession().getId());
            request.setAttribute("message", m);
            request.setAttribute("errors", errors);

            //フォワード
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/messages/new.jsp");
            rd.forward(request, response);
            } else {
            //データベースに保存
            em.getTransaction().begin();
            em.persist(m);
            em.getTransaction().commit();
            request.getSession().setAttribute("flush", "会員登録が完了しました。");
            em.close();

            //indexのページにリダイレクト
            response.sendRedirect(request.getContextPath() + "/index");
        }
    }
}
}