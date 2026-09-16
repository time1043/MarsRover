import { serve } from '@hono/node-server'
import { Hono } from 'hono'
import { readFile } from 'fs/promises'
import { join } from 'path'

const app = new Hono()

app.get('/', (c) => {
  return c.text('Mars Rover API Server')
})

app.get('/mars-photos/api/v1/manifests/:rover_name', async (c) => {
  const roverName = c.req.param('rover_name')
  const apiKey = c.req.query('api_key')

  // Accept any API key for local development
  try {
    const filePath = join(process.cwd(), 'data', `${roverName}.json`)
    const data = await readFile(filePath, 'utf-8')
    return c.json(JSON.parse(data))
  } catch (error) {
    return c.json({ error: 'Rover not found' }, 404)
  }
})

serve({
  fetch: app.fetch,
  port: 3000,
  hostname: '0.0.0.0'
}, (info) => {
  console.log(`Server is running on http://localhost:${info.port}`)
  console.log(`Server is accessible on your local network at http://YOUR_LOCAL_IP:${info.port}`)
})
