export type NoteBase = {
  id: string
  createdAt: number
  title?: string
  description?: string
}

export type TextNote = NoteBase & {
  kind: 'text'
  content: string // markdown
}

export type PhotoItem = {
  id: string
  src: string // object URL or data URL
  width?: number
  height?: number
}

export type PhotoNote = NoteBase & {
  kind: 'photo'
  photos: PhotoItem[]
}

export type LocationNote = NoteBase & {
  kind: 'location'
  name: string
  latitude: number
  longitude: number
}

export type Note = TextNote | PhotoNote | LocationNote