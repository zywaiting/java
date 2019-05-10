package xin.zhuyao.wechat_article.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import xin.zhuyao.wechat_article.domain.entity.ArticleUrlEntity;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zy
 * Date: 2019/5/10
 * Time: 12:53
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public interface ArticleUrlRepository extends JpaRepository<ArticleUrlEntity,Integer>{

    List<ArticleUrlEntity> findByStatus(boolean status);
}
