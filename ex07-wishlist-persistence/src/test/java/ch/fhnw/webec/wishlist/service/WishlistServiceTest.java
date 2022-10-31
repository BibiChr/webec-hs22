package ch.fhnw.webec.wishlist.service;

import ch.fhnw.webec.wishlist.SampleDataAdder;
import ch.fhnw.webec.wishlist.data.CategoryRepository;
import ch.fhnw.webec.wishlist.data.WishlistRepository;
import ch.fhnw.webec.wishlist.model.Category;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.io.IOException;

import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DataJpaTest
class WishlistServiceTest {

    WishlistService wishlistService;
    CategoryService categoryService;

    @Autowired
    WishlistServiceTest(WishlistRepository wishRepo, CategoryRepository catRepo) throws IOException {
        var mapper = new ObjectMapper().configure(FAIL_ON_UNKNOWN_PROPERTIES, false);
        wishlistService = new WishlistService(wishRepo);
        categoryService = new CategoryService(catRepo, wishlistRepository);
        new SampleDataAdder(mapper, wishlistService, categoryService).addSampleData();
    }

    @Test
    void countWishesByCategory() {
        //given
        Category category = mock(Category.class);
        when(category.getId()).thenReturn(1);

        //when

        //then
    }
}