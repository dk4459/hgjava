package co.yedam.product.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.common.Command;
import co.yedam.product.ProductVO;
import co.yedam.product.service.ProductService;
import co.yedam.product.service.ProductServiceImpl;

public class ProductListControl implements Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		
		ProductService svc = new ProductServiceImpl();
		ProductVO product = new ProductVO();
		List<ProductVO> list = svc.productList(product);
		
		req.setAttribute("list", list);
		String path = "product/productList.tiles";
		try {
			req.getRequestDispatcher(path).forward(req, res);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
