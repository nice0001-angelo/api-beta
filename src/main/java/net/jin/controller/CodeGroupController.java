//   public static void main(String[] args) {
//      // TODO Auto-generated method stub
//
//      // redShirt greenPants redShirt orange Shoes blackPants blackPants
//      // 가장 자주 구매한 상품에 대한 동점이 있을 경우 알파벳 순으로 오름차순으로 
//      // 정렬된 상품명과 목록의 성이 선택됩니다.
//      // 각각은 구매 한 제품을 나타냅니다.
//      // 추천 제품의 이름
//      // 알파벳 순으로 오름차순으로 제품을 주문하면 빨간색 셔츠가 마지막으로 나열됩니다.
//      // 빨간 셔츠는 다음날의 특집상품이다.
//      
//      List<String> products = new ArrayList<>();
//      products.add("yellowShirt");
//      products.add("redHat");
//      products.add("blackShirt");
//      products.add("bluePants");
//      products.add("redHat");
//      products.add("redHat");
//      products.add("pinkHat");
//      products.add("blackShirt");
//      products.add("yellowShirt");
//      products.add("greenPants");
//      products.add("greenPants");
//      products.add("greenPants");
//      products.add("greenPants");
//      products.add("redHat");
//      
//      int maxCount = 0;
//      
//      Map<String, Integer> productMap = new HashMap<String, Integer>();
//      for (String product : products) {
//         productMap.put(product, productMap.get(product) == null ? 1 : productMap.get(product) + 1);
//      }
//      
//      for (String key : productMap.keySet()) {
//         if (maxCount < productMap.get(key)) {
//            maxCount = productMap.get(key);
//         }
//      }
//      
//      for (Iterator<String> it = products.iterator(); it.hasNext();) {
//         String value = it.next();
//         if (productMap.get(value) < maxCount) {
//            it.remove();
//         }
//      }
//      
//      System.out.println(maxCount);
//      System.out.println(products.size());
//      
//      Collections.sort(products, Collections.reverseOrder());
//      System.out.println(products.get(0));
//      
//   }




/**
 * 
 */
package net.jin.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;

import lombok.extern.java.*;
import lombok.extern.slf4j.*;
import net.jin.domain.*;
import net.jin.service.*;

/**
 * @author njh
 *
 */

@Log
@RestController
@RequestMapping("/codegroups")
public class CodeGroupController {
	
	//private static final Logger log = java.util.logging.Logger.getLogger(LogExample.class.getName());
	
	@Autowired
	private CodeGroupService codeGroupService;
	

	
	//select all
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<CodeGroup>> list() throws Exception{
		return new ResponseEntity<List<CodeGroup>>(codeGroupService.list(), HttpStatus.OK);
	}
		
	// select by id
	@RequestMapping(value = "/{groupCode}", method = RequestMethod.GET)
	public ResponseEntity<CodeGroup> read(@PathVariable("groupCode") String groupCode) throws Exception{
		//CodeGroup codeGroup = codeGroupService.read(groupCode);
		//return new ResponseEntity<CodeGroup>(codeGroup, HttpStatus.OK);
		return new ResponseEntity<CodeGroup>(codeGroupService.read(groupCode), HttpStatus.OK);
 	}

	//create
	@RequestMapping(value ="", method = RequestMethod.POST)
	public ResponseEntity<CodeGroup> register(@Validated @RequestBody CodeGroup codeGroup) throws Exception{
		log.info("register");
		
		codeGroupService.register(codeGroup);
		
		log.info("register codeGroup.getGroupCode() = "+ codeGroup.getGroupCode());
		
		return new ResponseEntity<CodeGroup>(codeGroup, HttpStatus.OK); 
	}
	
	//delete by id
	@RequestMapping(value = "/{groupCode}", method = RequestMethod.DELETE)	
	public ResponseEntity<Void> remove(@PathVariable("groupCode") String groupCode) throws Exception {
		
		codeGroupService.remove(groupCode);
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	//	update
	@RequestMapping(value="{groupCode}", method = RequestMethod.PUT)
	public ResponseEntity<Void> modify(@PathVariable("groupCode") String groupCode, 
			@Validated @RequestBody CodeGroup codeGroup) throws Exception{
		codeGroup.setGroupCode(groupCode);
		
		codeGroupService.modify(codeGroup);
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		
	}
}
