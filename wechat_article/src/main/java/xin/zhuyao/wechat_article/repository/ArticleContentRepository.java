package xin.zhuyao.wechat_article.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import xin.zhuyao.wechat_article.domain.entity.ArticleContentEntity;

/**
 * Created with IntelliJ IDEA.
 * User: zy
 * Date: 2019/5/10
 * Time: 12:54
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public interface ArticleContentRepository extends JpaRepository<ArticleContentEntity,Integer>, JpaSpecificationExecutor<ArticleContentEntity> {
}
