const base = {
    get() {
        return {
            url : "http://localhost:8080/jiaxiaoyuyue/",
            name: "jiaxiaoyuyue",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/jiaxiaoyuyue/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "驾校预约平台"
        } 
    }
}
export default base
