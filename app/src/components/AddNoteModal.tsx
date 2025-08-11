import { useEffect, useState } from 'react'
import { addNote } from '../db'
import type { Note, PhotoItem, TextNote, LocationNote, PhotoNote } from '../types'
import ReactMarkdown from 'react-markdown'
import remarkGfm from 'remark-gfm'

function generateId(prefix: string = 'id'): string {
  return `${prefix}_${Math.random().toString(36).slice(2, 8)}_${Date.now().toString(36)}`
}

export default function AddNoteModal({ open, onClose, onCreated }: { open: boolean; onClose: () => void; onCreated: (note: Note) => void }) {
  const [tab, setTab] = useState<'text' | 'photo' | 'location'>('text')

  useEffect(() => {
    if (open) {
      setTab('text')
    }
  }, [open])

  if (!open) return null

  return (
    <div className="fixed inset-0 z-50 flex items-end md:items-center md:justify-center bg-black/40">
      <div className="w-full md:max-w-lg md:rounded-2xl md:shadow-xl bg-white dark:bg-neutral-900 border-t md:border border-neutral-200/70 dark:border-neutral-800/70">
        <div className="p-4 border-b border-neutral-200/60 dark:border-neutral-800/60 flex items-center justify-between">
          <h2 className="text-base font-semibold">Nieuwe notitie</h2>
          <button onClick={onClose} className="rounded-full p-2 hover:bg-neutral-100 dark:hover:bg-neutral-800" aria-label="Sluiten">✕</button>
        </div>
        <div className="px-4 pt-3">
          <div className="grid grid-cols-3 gap-1 rounded-lg bg-neutral-100 dark:bg-neutral-800 p-1">
            <button onClick={() => setTab('text')} className={`py-2 rounded-md text-sm font-medium ${tab==='text' ? 'bg-white dark:bg-neutral-900 shadow' : 'text-neutral-600 dark:text-neutral-300'}`}>Tekst</button>
            <button onClick={() => setTab('photo')} className={`py-2 rounded-md text-sm font-medium ${tab==='photo' ? 'bg-white dark:bg-neutral-900 shadow' : 'text-neutral-600 dark:text-neutral-300'}`}>Foto</button>
            <button onClick={() => setTab('location')} className={`py-2 rounded-md text-sm font-medium ${tab==='location' ? 'bg-white dark:bg-neutral-900 shadow' : 'text-neutral-600 dark:text-neutral-300'}`}>Locatie</button>
          </div>
        </div>
        {tab === 'text' && <TextForm onClose={onClose} onCreated={onCreated} />}
        {tab === 'photo' && <PhotoForm onClose={onClose} onCreated={onCreated} />}
        {tab === 'location' && <LocationForm onClose={onClose} onCreated={onCreated} />}
      </div>
    </div>
  )
}

function FieldRow({ label, children }: { label: string; children: React.ReactNode }) {
  return (
    <label className="block px-4 pt-4">
      <span className="text-xs font-medium text-neutral-600 dark:text-neutral-300">{label}</span>
      <div className="mt-1">{children}</div>
    </label>
  )
}

function FormActions({ onCancel, onSave, saveDisabled }: { onCancel: () => void; onSave: () => void; saveDisabled?: boolean }) {
  return (
    <div className="p-4 flex gap-3 justify-end">
      <button onClick={onCancel} className="px-4 py-2 rounded-lg border border-neutral-300 dark:border-neutral-700 hover:bg-neutral-50 dark:hover:bg-neutral-800">Annuleren</button>
      <button disabled={!!saveDisabled} onClick={onSave} className="px-4 py-2 rounded-lg bg-blue-600 text-white hover:bg-blue-700 disabled:opacity-50">Opslaan</button>
    </div>
  )
}

function TextForm({ onClose, onCreated }: { onClose: () => void; onCreated: (n: Note) => void }) {
  const [title, setTitle] = useState('')
  const [description, setDescription] = useState('')
  const [content, setContent] = useState('')
  const canSave = content.trim().length > 0

  async function handleSave() {
    const note: TextNote = {
      id: generateId('note'),
      createdAt: Date.now(),
      kind: 'text',
      title: title || undefined,
      description: description || undefined,
      content,
    }
    await addNote(note)
    onCreated(note)
    onClose()
  }

  return (
    <div>
      <FieldRow label="Titel (optioneel)">
        <input value={title} onChange={(e) => setTitle(e.target.value)} placeholder="Titel" className="w-full rounded-lg border border-neutral-300 dark:border-neutral-700 bg-transparent px-3 py-2" />
      </FieldRow>
      <FieldRow label="Omschrijving (optioneel)">
        <input value={description} onChange={(e) => setDescription(e.target.value)} placeholder="Omschrijving" className="w-full rounded-lg border border-neutral-300 dark:border-neutral-700 bg-transparent px-3 py-2" />
      </FieldRow>
      <div className="px-4 pt-4 grid md:grid-cols-2 gap-4">
        <div>
          <div className="text-xs font-medium text-neutral-600 dark:text-neutral-300">Tekst (Markdown, ondersteunt vet/cursief, lijsten, links)</div>
          <textarea value={content} onChange={(e) => setContent(e.target.value)} placeholder="Schrijf je notitie..." rows={10} className="mt-1 w-full rounded-lg border border-neutral-300 dark:border-neutral-700 bg-transparent px-3 py-2" />
          <div className="mt-2 text-xs text-neutral-500">Voor vet: **tekst**, cursief: *tekst*</div>
        </div>
        <div>
          <div className="text-xs font-medium text-neutral-600 dark:text-neutral-300">Voorbeeld</div>
          <div className="mt-1 rounded-lg border border-neutral-300 dark:border-neutral-700 p-3 prose prose-neutral dark:prose-invert max-w-none">
            <ReactMarkdown remarkPlugins={[remarkGfm]}>{content || '_Voorbeeld van je notitie_'}</ReactMarkdown>
          </div>
        </div>
      </div>
      <FormActions onCancel={onClose} onSave={handleSave} saveDisabled={!canSave} />
    </div>
  )
}

function PhotoForm({ onClose, onCreated }: { onClose: () => void; onCreated: (n: Note) => void }) {
  const [title, setTitle] = useState('')
  const [description, setDescription] = useState('')
  const [photos, setPhotos] = useState<PhotoItem[]>([])

  async function onFilesSelected(files: FileList | null) {
    if (!files) return
    const next: PhotoItem[] = []
    for (const file of Array.from(files)) {
      const dataUrl = await fileToDataUrl(file)
      next.push({ id: generateId('photo'), src: dataUrl })
    }
    setPhotos((prev) => [...prev, ...next])
  }

  function fileToDataUrl(file: File): Promise<string> {
    return new Promise((resolve, reject) => {
      const reader = new FileReader()
      reader.onload = () => resolve(String(reader.result))
      reader.onerror = reject
      reader.readAsDataURL(file)
    })
  }

  async function handleSave() {
    const note: PhotoNote = {
      id: generateId('note'),
      createdAt: Date.now(),
      kind: 'photo',
      title: title || undefined,
      description: description || undefined,
      photos,
    }
    await addNote(note)
    onCreated(note)
    onClose()
  }

  const canSave = photos.length > 0

  return (
    <div>
      <FieldRow label="Titel (optioneel)">
        <input value={title} onChange={(e) => setTitle(e.target.value)} placeholder="Titel" className="w-full rounded-lg border border-neutral-300 dark:border-neutral-700 bg-transparent px-3 py-2" />
      </FieldRow>
      <FieldRow label="Omschrijving (optioneel)">
        <input value={description} onChange={(e) => setDescription(e.target.value)} placeholder="Omschrijving" className="w-full rounded-lg border border-neutral-300 dark:border-neutral-700 bg-transparent px-3 py-2" />
      </FieldRow>
      <FieldRow label="Foto('s) toevoegen">
        <input type="file" accept="image/*" multiple onChange={(e) => onFilesSelected(e.target.files)} />
      </FieldRow>
      <div className="px-4 pt-4 grid grid-cols-2 md:grid-cols-3 gap-3">
        {photos.map((p) => (
          <img key={p.id} src={p.src} alt="preview" className="w-full h-36 object-cover rounded-lg border border-neutral-200 dark:border-neutral-800" />
        ))}
      </div>
      <FormActions onCancel={onClose} onSave={handleSave} saveDisabled={!canSave} />
    </div>
  )
}

function LocationForm({ onClose, onCreated }: { onClose: () => void; onCreated: (n: Note) => void }) {
  const [name, setName] = useState('')
  const [coords, setCoords] = useState<{ lat: number; lng: number } | null>(null)
  const [error, setError] = useState<string | null>(null)

  useEffect(() => {
    if (!('geolocation' in navigator)) {
      setError('Geolocatie niet ondersteund')
      return
    }
    navigator.geolocation.getCurrentPosition(
      (pos) => {
        setCoords({ lat: pos.coords.latitude, lng: pos.coords.longitude })
      },
      (err) => setError(err.message),
      { enableHighAccuracy: true, timeout: 10000 }
    )
  }, [])

  async function handleSave() {
    if (!coords) return
    const note: LocationNote = {
      id: generateId('note'),
      createdAt: Date.now(),
      kind: 'location',
      title: undefined,
      description: undefined,
      name: name || 'Locatie',
      latitude: coords.lat,
      longitude: coords.lng,
    }
    await addNote(note)
    onCreated(note)
    onClose()
  }

  const canSave = !!coords

  return (
    <div>
      <FieldRow label="Naam van de locatie">
        <input value={name} onChange={(e) => setName(e.target.value)} placeholder="Bijv. Chalet, Uitzichtpunt" className="w-full rounded-lg border border-neutral-300 dark:border-neutral-700 bg-transparent px-3 py-2" />
      </FieldRow>
      <div className="px-4 pt-4">
        {error && <div className="text-sm text-red-600">{error}</div>}
        {!coords && !error && <div className="text-sm text-neutral-600">Bezig met bepalen van je locatie…</div>}
        {coords && (
          <div className="text-sm text-neutral-700 dark:text-neutral-200">Gevonden: {coords.lat.toFixed(5)}, {coords.lng.toFixed(5)}</div>
        )}
      </div>
      <FormActions onCancel={onClose} onSave={handleSave} saveDisabled={!canSave} />
    </div>
  )
}