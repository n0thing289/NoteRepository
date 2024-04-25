Set ws = CreateObject("WScript.Shell")

ws.run "sftp root@120.79.139.31"
wscript.sleep 3000
ws.sendkeys("XU8pq.n5L7tgYZS")
ws.sendkeys("{ENTER}")
wscript.sleep 1000

ws.sendkeys("rm /www/server/nginx/html/vuepressdist/*")
ws.sendkeys("{ENTER}")


ws.sendkeys("put -r ./src/.vuepress/dist /www/server/nginx/html/vuepressdist")
ws.sendkeys("{ENTER}")

wscript.sleep 1000
wscript.quit 

