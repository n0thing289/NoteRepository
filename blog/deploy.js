import ssh2SftpClient from 'ssh2-sftp-client'
let Client = ssh2SftpClient 

let client = new Client();
const config = {
    host: '120.79.139.31',
    port: '22',
    username: 'root',
    password: 'XU8pq.n5L7tgYZS'
}
const localPath = './src/.vuepress/dist' //path.resolve(__dirname, './src/.vuepress/dist')
const remotePath = '/www/server/nginx/html/vuepressdist'
const main = async () => {
    try {
        await client.connect(config);
        if (await client.exists(remotePath)) {
            await client.rmdir(remotePath, true)
            console.log('删除成功')
        }
        let rslt = await client.uploadDir(localPath, remotePath);
        console.log('上传成功')
        return rslt;
    } finally {
        client.end();
    }
}

main();
//"deploy": "node ./scripts/deploy.js"

// 作者：摸鱼的春哥
// 链接：https://juejin.cn/post/7038596319132254222
// 来源：稀土掘金
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。