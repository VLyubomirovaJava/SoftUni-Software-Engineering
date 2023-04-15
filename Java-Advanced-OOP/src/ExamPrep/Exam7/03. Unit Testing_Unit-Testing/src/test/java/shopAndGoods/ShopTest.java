package shopAndGoods;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.management.OperationsException;
import javax.naming.OperationNotSupportedException;

public class ShopTest {
private Shop shop;

@Before
    public void setUp(){
    this.shop= new Shop();

}
@Test
    public void testAddShelf() throws OperationNotSupportedException {
    String shelf = "Shelves1";
    Goods goods = new Goods("Name","GoodsCode");
String result = this.shop.addGoods(shelf,goods);
    Assert.assertSame(goods,this.shop.getShelves().get(shelf));
}

    @Test(expected = IllegalArgumentException.class)
    public void TestAddingGoodsIfShelfIsTaken() throws OperationNotSupportedException {
        String shelf = "Shelves1";
        Goods goods = new Goods("Name","GoodsCode");
         this.shop.addGoods(shelf,goods);
        Goods goods2 = new Goods("Name2","GoodsCode2");
         this.shop.addGoods(shelf,goods2);

    }

    @Test(expected = IllegalArgumentException.class)
    public void TestIfShelfIsNull() throws OperationNotSupportedException {
    String shelf =null;
        Goods goods = new Goods("Name","GoodsCode");
        this.shop.addGoods(shelf,goods);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void TestAddGoodsThatExistAlready() throws OperationNotSupportedException {
        String shelf = "Shelves1";
        String shelf2 = "Shelves2";
        Goods goods = new Goods("Name","GoodsCode");
this.shop.addGoods(shelf,goods);
this.shop.addGoods(shelf2,goods);

    }

    @Test(expected = IllegalArgumentException.class)
    public void TestAddingGoodsToNonExistingShelf() throws OperationNotSupportedException {
        String shelf = "Shelf1";
        Goods goods = new Goods("Name","GoodsCode");
            this.shop.addGoods(shelf, goods);
    }

    @Test
    public void TestRemoveGoods() throws OperationNotSupportedException {
        String shelf = "Shelves1";
        Goods goods = new Goods("Name","GoodsCode");
        this.shop.addGoods(shelf, goods);
        this.shop.removeGoods(shelf,goods);
Assert.assertNull(this.shop.getShelves().get(shelf));
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestRemoveGoodsIfShelfDoesntExist() {
        String shelf = "Shelf1";
        Goods goods = new Goods("Name","GoodsCode");
        this.shop.removeGoods(shelf,goods);
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestRemoveNonExistingGoods() throws OperationNotSupportedException {
        String shelf = "Shelves1";
        Goods goods = new Goods("Name","GoodsCode");
        String shelf2 = "Shelves2";
        Goods goods2 = new Goods("Name2","GoodsCode2");
        this.shop.addGoods(shelf, goods);
        this.shop.addGoods(shelf2, goods2);
        this.shop.removeGoods(shelf,goods2);
    }


}