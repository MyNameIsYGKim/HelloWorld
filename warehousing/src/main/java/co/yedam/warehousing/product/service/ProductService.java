package co.yedam.warehousing.product.service;

import java.util.List;

public interface ProductService {
	int productInsert(ProductVO vo);
	int productUpdate(ProductVO vo);
	int productDelete(int no);
	List<ProductVO> productSelectList();
	List<ProductVO> productSelect(String str);
}
