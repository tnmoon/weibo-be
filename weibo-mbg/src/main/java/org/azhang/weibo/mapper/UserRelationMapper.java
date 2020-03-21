package org.azhang.weibo.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.azhang.weibo.model.UserRelation;
import org.azhang.weibo.model.UserRelationExample;

public interface UserRelationMapper {
    long countByExample(UserRelationExample example);

    int deleteByExample(UserRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserRelation record);

    int insertSelective(UserRelation record);

    List<UserRelation> selectByExample(UserRelationExample example);

    UserRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserRelation record, @Param("example") UserRelationExample example);

    int updateByExample(@Param("record") UserRelation record, @Param("example") UserRelationExample example);

    int updateByPrimaryKeySelective(UserRelation record);

    int updateByPrimaryKey(UserRelation record);
}