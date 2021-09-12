package corp.valhalla.checkfeignclient.repository;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import corp.valhalla.checkfeignclient.config.MyClientConfiguration;
import corp.valhalla.checkfeignclient.model.Category;

@FeignClient(value = "category", url = "http://localhost:8081/", configuration = MyClientConfiguration.class)
public interface CategoryRepository {

	@RequestMapping(method = RequestMethod.GET, value = "/api/categories")
    List<Category> getCategories();
	
	@RequestMapping(method = RequestMethod.GET, value = "/api/category/{uuid}", consumes = "application/json")
    Category getCategoryById(@PathVariable("uuid") String uuid);
}
