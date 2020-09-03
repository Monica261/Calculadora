/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * 
 */
@WebServlet({"*.action","/"})
public class HttpServletBasico extends HttpServlet{
    
    @Override
    public void doGet(HttpServletRequest req,
       HttpServletResponse res){
        
        String path = req.getServletPath();
        ServletContext sc = req.getServletContext();
        System.out.println(path); 
        switch (path){
            case "/":
            try{
                sc.getRequestDispatcher("/jsp/form.jsp").forward(req, res);
            } catch (Exception e){}
            break;
            case "/login.action":
            
            try{
                req.setCharacterEncoding("UTF-8");
                String id = req.getParameter("login");
                String pass = req.getParameter("senha");
                res.setContentType("text/html");
                res.setCharacterEncoding("UTF-8");
                req.setAttribute("login", id);
                req.setAttribute("senha", pass);
                sc.getRequestDispatcher("/jsp/resposta.jsp").forward(req, res);
            }catch (Exception e){}
            break;
            case "/calculo.action":
            try{
                req.setCharacterEncoding("UTF-8");
                String operacao = req.getParameter("operacao");
                //passando para float
                float opc1 = Float.parseFloat(req.getParameter("op1"));
                float opc2 = Float.parseFloat(req.getParameter("op2"));
                
                float resultado = 0;
                float i = 0;
            //switch de operacoes
                switch (operacao) {
                    case "+":
                    resultado = soma(opc1, opc2);
                    break;
                    case "-":
                    resultado = subtracao(opc1, opc2);
                    break;
                    case "*":
                    resultado = multiplicacao(opc1, opc2);
                    break;
                    case "/":
                    resultado = divisao(opc1, opc2);
                    break;
                    case "pot":
                    resultado = potencia(opc1, opc2);       
                    break;
                    case "raiz":
                    resultado = raiz(opc1, opc2);
                    break;
                    default:
                    break;
                }
                
                res.setContentType("text/plain");
                req.setAttribute("op1", opc1);
                req.setAttribute("op2", opc2);
                PrintWriter pw = res.getWriter();
                pw.write("Resultado: " + resultado);
                pw.close();
                
                    //sc.getRequestDispatcher("/jsp/teste.jsp").forward(req, res);
            }catch (Exception e){}
            case "/historico.action":
            try{
                sc.getRequestDispatcher("/jsp/historico.jsp").forward(req, res);
            }catch (Exception e){}
            default:
            try{
               sc.getRequestDispatcher("/jsp/nao_encontrado.jsp").forward(req, res);
           }catch (Exception e){}               
       }      
   } 
   private float soma(float opc1, float opc2){
       return opc1 + opc2;
   }
   private float subtracao(float opc1, float opc2){
       return opc1 - opc2;
   }
   private float multiplicacao(float opc1, float opc2){
       return opc1 * opc2;
   }
   private float divisao(float opc1, float opc2){
    if (opc2 == 0) {
        return (-1);
    }
    return (opc1 / opc2);
}

private float potencia(float opc1, float opc2) {
   if (opc2 <0 ){
     return 0;
 }

 if (opc1==1){
  return 1;
}

int potencia=1;

for ( int i = 0 ; i < opc2; i++){
 potencia *= opc1;
}

return potencia; 
}
public static float raiz(float opc1, float opc2) {
    float t;
    
    float squareRoot = opc1 / opc2;
    
    do {
        t = squareRoot;
        squareRoot = (t + (opc1 / t)) / opc2;
    } while ((t - squareRoot) != 0);
    
    return squareRoot;
}


}
