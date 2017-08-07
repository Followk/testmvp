package com.test.mvp;

import com.test.mvp.mode.AddressList;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/8/7.
 */

public class GetDataUtil {

    public  static   ArrayList<AddressList>  getAddressList(int page)
    {
        ArrayList<AddressList>  addressLists= new ArrayList<>();
        if (page==1)//刷新数据
        {

                addressLists.add(new AddressList("小明","1354502733","湖北省武汉市洪山区长城花园"));
                addressLists.add(new AddressList("赵四","1354502732","湖北省武汉市洪山区长情花园"));
                addressLists.add(new AddressList("李磊","1354502734","湖北省武汉市洪山区信服花园"));
                addressLists.add(new AddressList("黎明","1354502735","湖北省武汉市洪山区金地花园"));
                addressLists.add(new AddressList("张飞","1354502737","湖北省武汉市洪山区营地花园"));
                addressLists.add(new AddressList("章非","1354502738","湖北省武汉市洪山区和谐花园"));
                addressLists.add(new AddressList("上官存","1354502739","湖北省武汉市洪山区和平花园"));
                addressLists.add(new AddressList("孙晓明","1354502711","湖北省武汉市洪山区荷花花园"));
                addressLists.add(new AddressList("古田","1354502733","湖北省武汉市洪山区长桂花园"));
                addressLists.add(new AddressList("小已","1354502755","湖北省武汉市洪山区长城花园"));
                addressLists.add(new AddressList("乐视","1354502756","湖北省武汉市洪山区长新福园"));
            return   addressLists;
        }else {//上拉加载更多

                ArrayList<AddressList>  list= new ArrayList<>();
                list.add(new AddressList("小明","1354502733","湖北省武汉市洪山区长城花园"));
                list.add(new AddressList("赵四","1354502732","湖北省武汉市洪山区长情花园"));
                list.add(new AddressList("李磊","1354502734","湖北省武汉市洪山区信服花园"));
                list.add(new AddressList("黎明","1354502735","湖北省武汉市洪山区金地花园"));
                list.add(new AddressList("张飞","1354502737","湖北省武汉市洪山区营地花园"));
                list.add(new AddressList("章非","1354502738","湖北省武汉市洪山区和谐花园"));
                list.add(new AddressList("上官存","1354502739","湖北省武汉市洪山区和平花园"));
                list.add(new AddressList("孙晓明","1354502711","湖北省武汉市洪山区荷花花园"));
                list.add(new AddressList("古田","1354502733","湖北省武汉市洪山区长桂花园"));
                list.add(new AddressList("小已","1354502755","湖北省武汉市洪山区长城花园"));
                list.add(new AddressList("乐视","1354502756","湖北省武汉市洪山区长新福园"));

                java.util.Random random=new java.util.Random();// 定义随机类
                int result=random.nextInt(11);// 返回[0,11)集合中的整数，注意不包括11

                AddressList  addressList=  list.get(result);
                ArrayList<AddressList>  lists=new ArrayList<>();
                lists.add(addressList);
                return lists;
        }
    }
}
