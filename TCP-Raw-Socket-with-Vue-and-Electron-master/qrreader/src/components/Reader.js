import net from 'net'

export default {
  data() {
    return {
      ip: '127.0.0.1',
      port: '1234',
      message: 'test message',
      socket: null
    }
  },
  mounted() {
    const socket = new net.Socket()
    this.socket = socket
    console.log("🚀 ~ file: Reader.js:15 ~ mounted ~ socket:", socket)
    socket.on('data', (data) => console.log(data.toString()))
  },
  methods: {
    connect() {
      console.log("this.port:"+this.port)
      console.log("this.ip:"+this.ip)
      console.log("this.socket:"+this.socket)
      this.socket.connect(this.port, this.ip)
    },
    sendMessage() {
      console.log("🚀 ~ file: Reader.js:26 ~ sendMessage ~ this.message:", this.message)
      this.socket.write(this.message)
    }
  }
}



