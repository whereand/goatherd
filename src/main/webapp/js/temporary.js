//模拟点击事件
      function addTab(title, url){
          if ($('#admin').tabs('exists', title)){
              $('#admin').tabs('select', title);
          } else {
              var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:99%;"></iframe>';
              $('#admin').tabs('add',{
                  title:title,
                  content:content,
                  closable:true
              });
          }
      }