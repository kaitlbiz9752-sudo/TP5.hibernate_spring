import dao.IDao;
import entities.Categorie;
import entities.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import util.HibernateConfig;

public class Presentation2 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);

        IDao<Product> productDao = context.getBean("ProductDaoImpl",IDao.class);
        IDao<Categorie> categorieDao = context.getBean("CategorieDaoImpl", IDao.class);


        Categorie categorie = new Categorie();
        categorie.setNom("info");
        categorieDao.create(categorie);

        System.out.println("Categorie sauvegardé : " + categorie.getNom());



        Product product = new Product();
        product.setName("Produit 1");
        product.setPrice(100.0);
        product.setCategorie(categorie);

        

        productDao.create(product);

        System.out.println("Produit sauvegardé : " + product.getName());
    }
}
